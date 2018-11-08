import React from 'react'
import axios from '../../util/axios'
import NavBar from '../../components/NavBar'
import Material from '../../components/Material'
import VideoListBySubject from '../../components/VideoListBySubject'

export default class index extends React.Component {

    constructor() {
        super()
        this.state = {
            subjectId: 0,
            status: 'subscribe'
        }
        this.favoriteSubject = this.favoriteSubject.bind(this)
    }

    async componentDidMount() {
        let subjectId = this.props.url.query.subject_id
        this.setState({ 
            subjectId: subjectId 
        })
    }

    async favoriteSubject(status) {
        let favoriteStatus = status.target.value
        let subjectId = this.state.subjectId

        if(favoriteStatus == 'subscribe'){
            axios.post('')
            this.setState({
                status: 'unsubscribe' 
            })
        }else{
            axios.delete('')
            this.setState({
                status: 'subscribe' 
            })
        }
    }

    render() {
        return (
            <div>
                <NavBar />
                <div>
                    <button onClick={this.favoriteSubject} value={this.state.status}>
                        {this.state.status}
                    </button>
                </div>
                <VideoListBySubject subject_id={this.state.subjectId} />
                <Material subject_id={this.state.subjectId} />
            </div>
        )
    }
}