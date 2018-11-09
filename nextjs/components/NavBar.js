
import SearchBar from './SearchBar'
import React from 'react'
import ProfileCard from '../components/ProfileCard'
import axios from '../util/axios'
import Router from 'next/router'
import Head from 'next/head';
import Line from '../components/Line'
import ButtonS from '../components/ButtonS'

export default class NavBar extends React.Component {
  constructor() {
    super()
    this.state = {
      profile: {
        studentId: '',
        firstname: '',
        lastname: '',
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

        <ProfileCard profile={this.state.profile} />
        <Line color="white" />

      </div>



    )
  }
}