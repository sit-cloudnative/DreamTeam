import axios from 'axios'

const instance = axios.create({
  baseURL: 'https://dreamteam-gateway.mybluemix.net/',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': this.localStorage.getItem("token") || ' '
  }
});

export const userService = (token) => {
  return axios.create({
    baseURL: 'https://dreamteam-userservice.mybluemix.net/',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': token
    }
  });
}

export const subjectService =  (token) => {
  return axios.create({
    baseURL: 'https://dreamteam-subjectservice.mybluemix.net/',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': token
    }
  });
}


export const videoService =  (token) => {
  return axios.create({
    baseURL: 'https://dreamteam-videoservice.mybluemix.net/',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': token
    }
  });
}


export default instance