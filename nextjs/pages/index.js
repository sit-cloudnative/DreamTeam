import React from 'react'
import axios from '../util/axios'
import Router from 'next/router'

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
        index
      </div>
    )
  }
}