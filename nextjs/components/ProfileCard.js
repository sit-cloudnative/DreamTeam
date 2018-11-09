import React from 'react'
import SearchBar from './SearchBar'

const ProfileCard = (props) => {
    return (

        <div>

            This is profile
            <p className='font2'>{props.profile.firstname + '  ' + props.profile.lastname}</p>
        </div>
    )
}

export default ProfileCard;