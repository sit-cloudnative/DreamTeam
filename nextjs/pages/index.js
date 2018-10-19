import React from 'react'
import axios from '../util/axios'
import ReactPlayer from 'react-player'
import Videotitle from '../components/videotitle'
import NavBar from './NavBar'

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
      <div className ="container">
        <img style={{width:'250px'}} src={this.state.video.video_thumbnail}></img>
        <h2>{this.state.video.video_name}</h2>
        {console.log('teacher')}
        <Videotitle
        videotitle={this.state.video.video_name}
        teacher={this.state.video.teacher.teacher_name}
         />
        {this.state.video.video_date}
        <ReactPlayer url={this.state.video.player.hls_url} playing controls />
        
      </div>
    )
  }
}