import React from 'react'
import ProfileCard from '../components/ProfileCard'
import FavoriteSubjectCard from '../components/FavoriteSubjectCard'
import axios from '../util/axios'
import Router from 'next/router'
import Head from 'next/head';
import Line from '../components/Line'
import ButtonV from '../components/ButtonV'
import ButtonS from '../components/ButtonS'

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

      <div className="container">
        <Head>
          <link rel="stylesheet" href="/static/bootstrap.min.css" />
          <link href="/static/style.css" rel="stylesheet" />

        </Head>
        <ProfileCard profile={this.state.profile} />
        <FavoriteSubjectCard favoriteSubjects={this.state.profile.favoriteSubject} />
        <Line color="white" />
        <ButtonV />
        <ButtonS />
        <Line color="white" />
        
      </div>



    )
  }
}