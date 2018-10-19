import React from 'react'
import ReactPlayer from 'react-player'

const Video = (props) => {
    return (
        <div>
            <ReactPlayer url={props.video.player.hls_url} playing controls />
        </div>
    )
}

export default Video;