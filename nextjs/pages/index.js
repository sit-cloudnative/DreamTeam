import React from 'react'
import ProfileCard from '../components/ProfileCard'
import FavoriteSubjectCard from '../components/FavoriteSubjectCard'
import axios from '../util/axios'
import Router from 'next/router'
import Head from 'next/head';
import Line from '../components/Line'
import ButtonV from '../components/ButtonV'
import ButtonS from '../components/ButtonS'
import NavBar from '../components/NavBar';

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

      <div className="">
        <NavBar />
        <FavoriteSubjectCard favoriteSubjects={this.state.profile.favoriteSubject} />
        <ProfileCard profile={this.state.profile} />
        
      </div>



    )
  }
}