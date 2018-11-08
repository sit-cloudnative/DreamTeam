import React from 'react'
import axios from '../util/axios'
import Card from './Card'

class VideoList extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            videoList: [],
            subjectName: '',
            subjectId: 2
        }
    }

    async getList(subjectId){
        let {data} =await axios.get('video-service/videos/'+subjectId)
        
        this.setState({
            videoList: {data}.data,
            subjectName: ({data}.data[0].videoName.search('G.')>-1)? {data}.data[0].videoName.substring(0, {data}.data[0].videoName.search(' G')): {data}.data[0].videoName 
        })

        console.log(this.state.videoList[0].videoName)
    }

    componentDidMount(){
        this.getList(this.state.subjectId)
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
                    <button onClick={() => {this.getList(2)}} class="btn btn-dark">subject it fun</button>
                    <button onClick={() => {this.getList(5)}} class="btn btn-dark">subject com pro 1</button>
                    <button onClick={() => {this.getList(10)}} class="btn btn-dark">subject discrete</button>
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