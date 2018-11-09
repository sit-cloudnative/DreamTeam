import React from 'react'
import Row from 'reactstrap/lib/Row'
import Col from 'reactstrap/lib/Col'
import Card from 'reactstrap/lib/Card'
import axios from '../util/axios'

export default class Profile extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            profile: {
                studentId: '',
                firstname: '',
                lastname: '',
                favoriteSubject: [
                    {
                        subjectId: 0,
                        subjectName: ''
                    }
                ]
            }
        }
    }

    async componentDidMount() {
        let studentId  = localStorage.getItem('profileId')
        console.log(studentId)
        let { data } = await axios.get(`profile-service/profile/${studentId}`)
        this.setState({
            profile: data
        })
        console.log(data)
    }

    render() {
        return (
            <div>

                <div className="card">
                    <div className="card-header">
                        <h3>Profile</h3>
                    </div>
                    <div className="card-body">
                        <p>
                            <b>Student Id: </b>
                            {this.state.profile.studentId}
                        </p>
                        <p>
                            <b>Student Name: </b>
                            {this.state.profile.firstname} {this.state.lastname}
                        </p>
                        <p>
                            <b>Favorite Subject: </b> {this.state.profile.favoriteSubject.map(subject => {
                                <li>
                                    {subject.subjectName}
                                </li>
                            })}
                        </p>
                    </div>
                </div>

            </div>
        )
    }
}