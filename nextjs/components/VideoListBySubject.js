import React from 'react'
import axios from '../util/axios'
import Card from './Card'

class VideoListBySubject extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            videoList: [],
            subjectName: '',
            subjectId: 0
        }
    }

    async getList(subjectId){      
        let {data} =await axios.get('videoList/'+subjectId)      
        this.setState({
            videoList: {data}.data,
            subjectName: ({data}.data[0].videoName.search('G.')>-1)? {data}.data[0].videoName.substring(0, {data}.data[0].videoName.search(' G')): {data}.data[0].videoName 
        })
        console.log(this.state.videoList[0].videoName)
    }

    componentDidUpdate() {
        this.getList(this.props.subject_id)
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
                    {cards}
                </div>
            </div>
        )
    }
}
export default VideoListBySubject