import React from 'react'
import axios from '../../util/axios'
import Video from './video'
import NavBar from '../NavBar'
import Videotitle from '../../components/videotitle'
import { withRouter } from 'next/router'

export default class index extends React.Component{
  constructor(){
    super()
    this.state = {
      video:{
        player:'',
        teacher:{
          teacher_name:'-'
        }
      }
    }
  }

  async componentDidMount() {
    const {router} = this.props
    const videoId = this.props.url.query.video_id
    let {data}  =await axios.get(`/video/${videoId}`)
    this.setState({video:data})
    console.log(this.state.video.player)
    console.log('router : ',router)

  }

  render(){
    return (
      <div>
        <NavBar />
        <VideoTitle
        videotitle={this.state.video.video_name}
        teacher={this.state.video.teacher.teacher_name}
         />
        <div className='justify-content-md-center' style={{width:'100%',display:'flex'}}>
          <Video style={{justifyContent:'center'}} video={this.state.video} playing controls />
        </div>
      </div>
    )
  }
}