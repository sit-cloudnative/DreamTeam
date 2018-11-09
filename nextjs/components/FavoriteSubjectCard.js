import React from 'react'
import Router from 'next/router'
import styled from 'styled-components'

const redirectToVideoListPage = (targetSubjectId) => {
    Router.push({
        pathname:'/videos',
        query:{subject_id:targetSubjectId}
    })
}

const FavoriteSubjectCard = (props) => {
    return (
        <div>
            {props.favoriteSubjects.map(subject => (
                <div className='card' onClick={() => {redirectToVideoListPage(subject.subjectId)}} key={subject.subjectId}>{subject.subjectName}</div>
            ))}
        </div>
    )
}

export default FavoriteSubjectCard;