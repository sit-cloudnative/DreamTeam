import React from 'react'

const ProfileCard = (props) => {
    return (

        <div>
            <div class="card text-center" style={{boxShadow:'0 3px 5px', margin: '50px', fontFamily: 'Georgia'}}>               
                <i class="fa fa-user" style={{fontSize: '300px'}}></i>
                <div class="card-body">
                    <h3 class="card-title" style={{backgroundColor: 'aquamarine'}}><b>Student Id</b>  </h3>
                    <p class="card-text" style={{fontSize: '20px'}}>{props.profile.studentId}</p>
                    <h3 class="card-title" style={{backgroundColor: 'aquamarine'}}><b>Student Name</b> </h3>
                    <p class="card-text" style={{fontSize: '20px'}}>{props.profile.firstname} {props.profile.lastname}</p>
                </div>
            </div>
        </div>

    )
}

export default ProfileCard;