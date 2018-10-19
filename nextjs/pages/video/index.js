import React from 'react'
import axios from '../util/axios'
import ReactPlayer from 'react-player'

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

  async componentDidMount() {
    let {data}  =await axios.get('/video/8380')
    this.setState({video:data})

  }

  render(){
    return (
      <div>
        <img style={{width:'250px'}} src={this.state.video.video_thumbnail}></img>
        {this.state.video.video_name}
        {this.state.video.video_date}
        {this.state.video.video_name}
        <ReactPlayer url={this.state.video.player.hls_url} playing controls />
        
      </div>
    )
  }
}