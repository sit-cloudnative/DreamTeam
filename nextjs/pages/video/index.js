import React from 'react'
import axios from '../../util/axios'
import Video from './video'
import NavBar from '../NavBar'

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
    console.log(this.state.video)

  }

  render(){
    return (
      <div>
        <NavBar />
        {this.state.video.video_name}
        <Video video={this.state.video} playing controls />
      </div>
    )
  }
}