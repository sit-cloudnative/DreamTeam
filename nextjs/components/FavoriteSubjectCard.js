import React from 'react'
import Router from 'next/router'

const redirectToVideoListPage = (targetSubjectId) => {
    Router.push({
        pathname: '/videos',
        query: { subject_id: targetSubjectId }
    })
}

const FavoriteSubjectCard = (props) => {
    return (
        <div className="row card-deck m-5">
            {props.favoriteSubjects.map(subject => (
                    <div onClick={() => { redirectToVideoListPage(subject.subjectId) }} key={subject.subjectId}>
                        <div className="card btn bg-dark card-block shadow-sm p-3 mb-5" style={{width: '400px'}}>
                            <div className="card-header">
                                <img class="img-thumbnail" src="https://image.ibb.co/jJM14f/wordpress-e-learning-website.jpg" style={{ width: '300px', height: '200px' }} />
                            </div>
                            <div className="card-body">
                                <div class="list-group">
                                    <p className='text-truncate' style={{ fontSize: '20px', textOverflow: 'ellipsis', color: '#ffffff' }}>{subject.subjectName}</p>
                                </div>
                            </div>
                        </div>
                    </div>
            ))
            }
        </div>
    )
}

export default FavoriteSubjectCard;