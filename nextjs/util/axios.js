import axios from 'axios'

const instance = axios.create({
  baseURL: 'https://dreamteam-gateway.mybluemix.net/',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': localStorage.getItem("token") || ' '
  }
});

export const userService = axios.create({
  baseURL: 'https://dreamteam-userservice.mybluemix.net/',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': localStorage.getItem("token") || ' '
  }
});

export const subjectService = axios.create({
  baseURL: 'https://dreamteam-subjectservice.mybluemix.net/',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': localStorage.getItem("token") || ' '
  }
});

export const userService = axios.create({
  baseURL: 'https://dreamteam-videoservice.mybluemix.net/',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': localStorage.getItem("token") || ' '
  }
});

export default instance