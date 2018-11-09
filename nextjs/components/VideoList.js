import React from 'react'
import axios from '../util/axios'
import Card from './Card'

class VideoList extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            targetSubject:'',
            videoList: [],
            subjectName: '',
        }
    }

    // async getList(subjectId){
    //     let {data} = await axios.get('video-service/videos/'+this.props.subjectId)
        
    //     this.setState({
    //         videoList: {data}.data,
    //         subjectName: ({data}.data[0].videoName.search('G.')>-1)? {data}.data[0].videoName.substring(0, {data}.data[0].videoName.search(' G')): {data}.data[0].videoName 
    //     })

    // }

    async componentDidMount(){
        let {data} = await axios.get('video-service/videos/'+this.props.subjectId)
        this.setState({videoList:data})
    }
    
    render(){
        const cards = this.state.videoList.map(video => {
            return <Card 
                        image={video.videoThumbnail} 
                        videoId = {video.videoId} 
                        key ={video.videoId} 
                        lecturer={video.lecturer} />
        })
        
        return (
            <div>
                <div className="row">
                    <div className="col-1"></div>
                    <h3 className="">{this.state.subjectName}</h3>
                </div>
                <hr />
                <div className="row">
                    {cards}
                </div>
            </div>
        )
    }
}
export default VideoList