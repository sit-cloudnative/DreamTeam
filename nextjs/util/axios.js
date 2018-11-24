import axios from 'axios'

const instance = axios.create({
  baseURL: 'https://dreamteam-gateway.mybluemix.net/',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': localStorage.getItem("token") || ' '
  }
});

export const userService = axios.create({
  baseURL: 'localhost:8080/',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': localStorage.getItem("token") || ' '
  }
});

export const subjectService = axios.create({
  baseURL: 'localhost:8081/',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': localStorage.getItem("token") || ' '
  }
});

export const userService = axios.create({
  baseURL: 'localhost:8082/',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': localStorage.getItem("token") || ' '
  }
});

export default instance