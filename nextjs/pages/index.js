import React from 'react'
import axios from '../util/axios'

export default class index extends React.Component{
  constructor(){
    super()
    this.state = {
      video:{
        player:{
          hls_url:''
        }
      }
    }
  }
  
  render(){
    return (
      <div className ="container">
        indexpage
      </div>
    )
  }
}