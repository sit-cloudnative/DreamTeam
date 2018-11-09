import React from 'react'
import 'isomorphic-fetch'
import axios from '../util/axios'
import CardSubject from '../components/CardSubject'
import styled from 'styled-components'
import Router from 'next/router'
import { get } from 'http';

const CurriculumCard = styled.a`
background-color:gray;
margin:44px;
min-height:70px;
padding:11px;
size:36px;
`
export default class SubjectList extends React.Component {

    constructor() {
        super()
        this.state = {
            curriculum: [],
            subjectList: []
        }
        this.getSubjectList = this.getSubjectList.bind(this)
    }

    async componentDidMount() {
        let {data} = await axios.get('subject-service/curriculums')
        this.setState({ 
            curriculum: {data}.data 
        })
    }

    async getSubjectList(targetCurriculumId) {
        const {data} = await axios.get('subject-service/curriculum/'+ targetCurriculumId+'/subjectlist')
        this.setState({ subjectList: data })
    }

    redirectToVideoListPage(targetSubjectId) {
        Router.push({
            pathname:'/videos',
            query:{subject_id:targetSubjectId}
        })
    }

    render() {

        const cardSubject = this.state.subjectList.map(subject => {
            return <CardSubject 
                    subject_id = {subject.subjectId}
                    subject_name = {subject.subjectName}
            />
        })

        return (
            <div className='container'>
                <div className='row'>
                <div className='btn btn-light' style={{overflowY:'scroll',maxHeight:'550px', textAlign:'center'}}>
                    {this.state.curriculum.map(curriculum =>
                            <CurriculumCard onClick={() => {this.getSubjectList(curriculum.curriculumId)}} value={curriculum.curriculumId} className='card2' key={curriculum.curriculumId}>
                                {curriculum.curriculumCode}
                            </CurriculumCard>
                    )}
                </div>
                <div className='btn btn-light' style={{overflowY:'scroll',maxHeight:'550px', textAlign:'center'}}>
                    {this.state.subjectList.map(subject => (
                        <CurriculumCard key={subject.subjectId} onClick={()=> {this.redirectToVideoListPage(subject.subjectId)}} value={subject.subjectId} className='row'>
                            {subject.subjectName}
                        </CurriculumCard>
                    ))}
                </div>
                </div>
            </div>
        )
    }
}