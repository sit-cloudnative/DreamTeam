import React from 'react'

const ProfileCard = (props) => {
    return (
        <div>
            <h1>Welcome {props.profile.firstname+'  '+props.profile.lastname}</h1>
        </div>
    )
}

export default ProfileCard;