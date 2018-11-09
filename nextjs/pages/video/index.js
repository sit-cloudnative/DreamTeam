import React from 'react'
import axios from '../../util/axios'
import Video from '../../components/Video'
import NavBar from '../../components/NavBar'
import Footer from '../../components/Footer'
import VideoTitle from '../../components/videotitle'
import CommentList from '../../components/CommentList'
import { withRouter } from 'next/router'

export default class index extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      video: {
        videoPath: '',
        lectuler: ''
      },
      comment: {
        content: '',
        postUserId: '',
        videoId: ''
      },
      commentList: []
    }
  }

  async componentDidMount() {
    const videoId = this.props.url.query.video_id
    const {data} =await axios.get(`/comment-service/comment/${videoId}`)
    this.setState({
      commentList: data
    })

    let video = await axios.get(`video-service/video/${videoId}`)
    this.setState({ video: video.data })
    this.handleOnSubmit = this.handleOnSubmit.bind(this)
  }

  async handleOnSubmit(e){
    const {data} =await axios.post('comment-service/comment',{
        content: this.state.comment.content,
        postUserId: parseInt(localStorage.getItem('profileId')),
        videoId: parseInt(this.props.url.query.video_id)
    })
    await this.setState({comment:data})
  }

  render() {
    return (
      <div>
        <NavBar />
        <VideoTitle
          videotitle={this.state.video.videoName}
          teacher={this.state.video.lecturer}
        />
        <div className='justify-content-md-center' style={{ width: '100%', display: 'flex' }}>
          <Video style={{ justifyContent: 'center' }} video={this.state.video} playing controls />
        </div>
        <div className="container" style={{ width: '100%'}}>
          <CommentList commentList={this.state.commentList} videoId={this.props.url.query.video_id}/>
          <div>
            <div className="input-group form-group">
              <div className="input-group-prepend">
                <span className="input-group-text"><i className="fas fa-user"></i></span>
              </div>
              <input type="text" className="form-control" placeholder="Comment" name="comment" onChange={(e)=>{this.setState({comment:{content: e.target.value}})}} />
            </div>
            <div className="form-group">
              <button className="btn float-right login_btn" onClick={this.handleOnSubmit} >Comment</button>
            </div>
          </div>
        </div>
        <Footer />
      </div>
    )
  }
}