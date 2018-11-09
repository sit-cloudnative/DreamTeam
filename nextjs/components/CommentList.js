import React from 'react'
import Comment from './Comment'
import axios from '../util/axios'

export default class extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            commentList: []
        }
    }
    componentDidMount(){
    }
    render() {
        const commentList = this.props.commentList.map((comment) => {
            return <Comment comment={comment} key={comment.id}/>
        })
        return (
            <div>
                {commentList}
            </div>
        )
    }
}
