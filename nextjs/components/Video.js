import React from 'react'
import ReactPlayer from 'react-player'

const Video = (props) => {
    return (
        <div>
            <ReactPlayer url={props.video.player} playing controls />
        </div>
    )
}

export default Video;