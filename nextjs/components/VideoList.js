import React from 'react'

class VideoList extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            videoList: []
        }
    }

    render(){
        videos = this.state.videoList.
        return (
            <div>
                {videos}
            </div>
        )
    }
}
export default VideoList