import React from 'react'
import NavBar from '../../components/NavBar'
import Footer from '../../components/Footer'
import VideoList from '../../components/VideoList'

export default class extends React.Component {

    constructor() {
        super()
        this.state = {
            subjectId: ''
        }
    }

    render() {
        const subjectId = this.props.url.query.subject_id
        return (
            <div>
                <NavBar />
                    <VideoList  subjectId={subjectId} /> 
                <Footer />
            </div>
        )
    }
}