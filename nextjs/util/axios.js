import axios from 'axios'
export const userService = (token) => {
  return axios.create({
    baseURL: 'https://dreamteam-userservice.mybluemix.net/',
    headers: {
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin' : '*',
      'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers':'origin, content-type, accept, x-requested-with',
      'Access-Control-Max-Age':'3600',
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
