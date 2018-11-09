import React from 'react'
import ProfileCard from '../components/ProfileCard'
import FavoriteSubjectCard from '../components/FavoriteSubjectCard'
import axios from '../util/axios'
import NavBar from '../components/NavBar';
import Row from '../node_modules/reactstrap/lib/Row'
import Col from '../node_modules/reactstrap/lib/Col'
import Footer from '../components/Footer'

export default class index extends React.Component {
  constructor() {
    super()
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
    let user = localStorage.getItem('profileId')
    let { data } = await axios.get('profile-service/profile/' + user)
    this.setState({ profile: data })
    console.log(data)
  }

  render() {

    return (
      <div>

        <div style={{ backgroundColor: '#f5f5f0' }}>
          <NavBar studentId={this.state.profile.studentId} />
          <h1 className="text-center" style={{ fontFamily: 'Georgia', margin: '20px' }}><b> Welcome To Dream-Learning </b> </h1>
          <div className="container-fluid">

            <Row>
              <Col md={3}></Col>

              <Col md={6}>
                <div className="profile-detail">
                  <ProfileCard profile={this.state.profile} />
                </div>
              </Col>

              <Col md={3}></Col>
            </Row>

            <Row>
              <Col md={4}></Col>

              <Col md={4}>
                <div className="favorite-subject">
                  <FavoriteSubjectCard favoriteSubjects={this.state.profile.favoriteSubject} />
                </div>
              </Col>

              <Col md={4}></Col>
            </Row>

          </div>
          <Footer />
        </div>
      </div>
    )
  }
}