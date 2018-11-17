import React from 'react'
import ProfileCard from '../components/ProfileCard'
import FavoriteSubjectCard from '../components/FavoriteSubjectCard'
import axios from '../util/axios'
import NavBar from '../components/NavBar'
import Row from '../node_modules/reactstrap/lib/Row'
import Col from '../node_modules/reactstrap/lib/Col'
import Footer from '../components/Footer'
import Carousel from '../components/Carousel'
import AOS from 'aos'

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
    AOS.init()
  }

  componentWillReceiveProps (){ 
    AOS.refresh()
  }

  render() {
    return (
      <div>
        <div style={{ backgroundColor: '#f5f5f0' }}>
          <NavBar studentId={this.state.profile.studentId} />

            <Row>
              <Col md={4}>
                <div className="profile-detail">
                  <ProfileCard profile={this.state.profile} />
                </div>
              </Col>

              <Col md={8}>
                <div>
                  <Carousel />
                </div>
              </Col>
            </Row>

              <hr />

            <Row>
              <div data-aos="zoom-in">
                <FavoriteSubjectCard favoriteSubjects={this.state.profile.favoriteSubject} />
              </div>
            </Row>
          </div>
          <Footer />
        </div>
    )
  }
}