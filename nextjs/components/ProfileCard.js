import React from 'react'
import SearchBar from './SearchBar'

const ProfileCard = (props) => {
    return (

        <div>
            <link rel="stylesheet" href="/static/bootstrap.min.css" />
            <link href="/static/style.css" rel="stylesheet" />


            <p className='font1'>D-Learning</p>
            <p className='font2'>{props.profile.firstname + '  ' + props.profile.lastname}<SearchBar handleOnSearch={props.handleOnSearch} />
             </p>

        </div>
    )
}

export default ProfileCard;