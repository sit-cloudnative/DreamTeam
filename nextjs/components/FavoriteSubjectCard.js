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
                <div className='card2' onClick={() => {redirectToVideoListPage(subject.subjectId)}} key={subject.subjectId}>
                <p className='btn btn-light' >{subject.subjectName}</p></div>
            ))}
            
        </div>
    )
}

export default FavoriteSubjectCard;