import React from 'react'

export default (props) => {
    return (
        <div>
            <div className="card">
                <div className="card-body">
                    <h5 className="card-title">{props.comment.postUserId}</h5>
                    <div className="card-footer">
                        <small className="text-muted">{props.comment.content}</small>
                    </div>
                </div>
            </div>
        </div>
    )
}