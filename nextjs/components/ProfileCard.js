import React from 'react'

const ProfileCard = (props) => {
    return (

        <div>
            <div class="card text-center bg-dark" style={{ boxShadow: '0 3px 5px', margin: '50px', fontFamily: 'Lucida Console' }}>
                <div class="card-header center">
                    <img class="img-thumbnail" src="https://image.ibb.co/dG2XCA/boy.png" style={{ width: '100%', height: '200px' }} />
                </div>
                <div class="card-body">
                    <h3 class="card-title" style={{ backgroundColor: '#f0f0f0' }}><b>Student Id</b>  </h3>
                    <p class="card-text" style={{ fontSize: '20px', color: '#ffffff' }}>{props.profile.studentId}</p>
                    <h3 class="card-title" style={{ backgroundColor: '#f0f0f0' }}><b>Student Name</b> </h3>
                    <p class="card-text" style={{ fontSize: '20px', color: '#ffffff' }}>{props.profile.firstname} {props.profile.lastname}</p>
                </div>
            </div>
        </div>

    )
}

export default ProfileCard;