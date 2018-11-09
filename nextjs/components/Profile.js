import React from 'react'
import Row from 'reactstrap/lib/Row'
import Col from 'reactstrap/lib/Col'
import Card from 'reactstrap/lib/Card'
import axios from '../util/axios'

export default class Profile extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            studentId: 59130500060,
            firstname: '',
            lastname: '',
            favoriteSubject: []
        }
    }

    async componentDidMount() {
        let studentId = this.state.studentId
        console.log(studentId)
        let {data} = await axios.get(`profile-service/profile/${studentId}`)
        this.setState({
            studentId: {data}.data.studentId,
            firstname: {data}.data.firstname,
            lastname: {data}.data.lastname,
            favoriteSubject: {data}.data.favoriteSubject
        })
        console.log("firstname: " + this.state.firstname)
    }

    render() {
        return (
            <div>

                <div className="d-flex justify-content-center h-100">
                    <div className="card" style={{ justifyContent: 'center', display: 'flex' }}>
                        <div className="card-header">
                            <h3>Profile</h3>
                        </div>
                        <div className="card-body">
                            <p>
                                <b>Student Id: </b>
                                {this.state.studentId}
                            </p>
                            <p>
                                <b>Student Name: </b>
                                {this.state.firstname} {this.state.lastname}
                            </p>
                            <p>
                                <b>Favorite Subject: </b> {this.state.favoriteSubject.map(subject => {
                                    <li>
                                        {subject.subjectName}
                                    </li>
                                })}
                            </p>
                        </div>
                    </div>
                </div>

            </div>
        )
    }
}