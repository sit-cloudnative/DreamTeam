import axios from 'axios'

const instance = axios.create({
  baseURL: 'http://localhost:80',
  headers: {
  }
});

export default instance