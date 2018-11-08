import React from 'react'
import NavBar from '../../components/NavBar'
import VideoList from '../../components/VideoList'

export default class extends React.Component {

    constructor() {
        super()
        this.state = {
            subjectId: '',
            subjectName: ''
        }
    }

    render() {
        return (
            <div>
                <NavBar />
                <VideoList />
            </div>
        )
    }
}