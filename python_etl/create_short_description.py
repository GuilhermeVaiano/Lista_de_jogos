import pandas as pd
import requests, json
import openai

gamelist_api_url = 'http://localhost:8080'
openai_api_key = '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'
openai.api_key = openai_api_key


def get_title_ids():
  df = pd.read_csv('title_ids.csv')
  title_ids = df['TitleID'].tolist()
  return title_ids

def get_games(id):
  response = requests.get(f'{gamelist_api_url}/games/{id}')
  return response.json() if response.status_code == 200 else None

def generate_ai_description(game):
    completion = openai.ChatCompletion.create(
    model="gpt-3.5-turbo",
    messages=[
      {
          "role": "system",
          "content": "Você é um especialista em video games."
      },
      {
          "role": "user",
          "content": f"Crie uma descrição para o jogo {game['title']} em ingles (máximo de 150 caracteres)"
      }
    ]
  )

    return completion.choices[0].message.content.strip('\"')

def update_short_description(game):
  payload = {
    "shortDescription": game['shortDescription']
  }
  put_url = f"{gamelist_api_url}/games/{game['id']}/update-short-description"
  print(put_url)
  response = requests.put(put_url, json=payload)
  print(response.status_code)
  return True if response.status_code == 200 else False


def generate_descriptions(gamelist):
  for game in gamelist:
    description = generate_ai_description(game)
    game['shortDescription'] = description
    game_update_success = update_short_description(game)
    print(f"The title {game['title']} was successfully updated: {game_update_success}")

  
id_game_list = get_title_ids()
gamelist = [game for id in id_game_list if (game := get_games(id)) is not None]
generate_descriptions(gamelist)
#print(json.dumps(gamelist, indent=2)) # Para visualizar os objetos obtidos