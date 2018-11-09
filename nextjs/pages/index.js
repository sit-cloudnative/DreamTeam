import React from 'react'
import ProfileCard from '../components/ProfileCard'
import FavoriteSubjectCard from '../components/FavoriteSubjectCard'
import axios from '../util/axios'

export default class index extends React.Component{
  constructor(){
    super()
    this.state = {
      profile:{
        studentId:'',
        firstname:'',
        lastname:'',
        favoriteSubject:[
          {
            subjectId:0,
            subjectName:''
          }
        ]
      }
    }
  }

  async componentDidMount() {
    let user = localStorage.getItem('profileId')
    let {data} = await axios.get('profile-service/profile/'+user)
    this.setState({profile:data})
    console.log(data)
  }
  
  render(){
    return (
      <div className ="container">
        <ProfileCard profile={this.state.profile} />
        <FavoriteSubjectCard favoriteSubjects={this.state.profile.favoriteSubject} />
      </div>
    )
  }
}