import React from 'react'

const Comment = (props) => {
    return (
        <div>
            <div className="card">
                <div className="card-body">
                    <h5 className="card-title">Comment 1</h5>
                    <div className="card-footer">
                        <small className="text-muted">WOW very good</small>
                    </div>
                </div>
                <p className="card-text">...</p>
            </div>
        </div>
    )
}

export default Comment;