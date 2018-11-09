import React from 'react'
import Router from 'next/router'
import styled from 'styled-components'

const redirectToVideoListPage = (targetSubjectId) => {
    Router.push({
        pathname: '/videos',
        query: { subject_id: targetSubjectId }
    })
}


const FavoriteSubjectCard = (props) => {
    return (
        <div className="card text-center" style={{ boxShadow: '0 3px 5px', margin: '50px', fontFamily: 'Georgia'}}>
            <div className="card-title">
                <i class="fa fa-heart" style={{fontSize: '80px', color: ' #e60000'}}></i>
                <h2><b>My Favorite Subject</b></h2>
            </div>            

            {props.favoriteSubjects.map(subject => (
                <div className="card-body">
                    <div onClick={() => { redirectToVideoListPage(subject.subjectId) }} key={subject.subjectId}>
                        <div class="list-group">
                            <p className='btn btn-dark' style={{ fontSize: '17px' }}>{subject.subjectName}</p>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    )
}

export default FavoriteSubjectCard;