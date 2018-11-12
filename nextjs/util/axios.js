import axios from 'axios'

const instance = axios.create({
  baseURL: 'https://dreamteam-gateway.mybluemix.net/',
  headers: {
    'Content-Type': 'application/json',
  }
});

export default instance