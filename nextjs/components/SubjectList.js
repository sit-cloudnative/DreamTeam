import React from 'react'
import 'isomorphic-fetch'
import axios from '../util/axios'
import styled from 'styled-components'
import Router from 'next/router'
import { get } from 'http';

const CurriculumCard = styled.a`
background-color:white;
min-height:70px;
padding:11px;
size:36px;
display:flex;
justify-content:center;
`
export default class SubjectList extends React.Component {

    constructor() {
        super()
        this.state = {
            curriculum: [],
            subjectList: [],
            curriculumCode: ''
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
        return (
            <div className='container'>
                <div className="row" style={{marginTop: '10px', marginBottom: '10px'}}>
                    <div className="col-6">
                        <h2>Curriculum</h2>
                    </div>
                    <div className="col-6">
                        {(this.state.subjectList.length!=0)?<h2>{this.state.curriculumCode}</h2>:''}
                    </div>
                </div>
                <div className='row'>
                    <div className='col-6' style={{overflowY:'scroll',maxHeight:'550px'}}>
                        {this.state.curriculum.map(curriculum =>
                                <CurriculumCard onClick={() => {this.getSubjectList(curriculum.curriculumId); this.setState({curriculumCode:curriculum.curriculumCode})}} value={curriculum.curriculumId} className='card' key={curriculum.curriculumId}>
                                    <div className="row">
                                        <div className="col-2">
                                            {(curriculum.curriculumCode == this.state.curriculumCode)?<i className="fa fa-chevron-right fa-2x" aria-hidden="true"></i>:<i className="fa fa-graduation-cap fa-2x" aria-hidden="true"></i>} 
                                        </div>

                                        <div className="col-9" style={{whiteSpace: 'nowrap', overflow: 'hidden', textOverflow: 'ellipsis'}} >
                                            <p style={{marginTop: '-1px', marginBottom: '-2px'}}>

                                                {curriculum.curriculumCode}
                                            </p>
                                            <p style={{marginBottom: '-1px'}}>
                                                {curriculum.curriculumName}
                                            </p>
                                        </div>
                                    </div>
                                </CurriculumCard>
                        )}
                    </div>
                    <div className="col-6" style={{overflowY:'scroll',maxHeight:'550px'}}>
                        {this.state.subjectList.map(subject => (
                            <CurriculumCard key={subject.subjectId} onClick={()=> {this.redirectToVideoListPage(subject.subjectId)}} value={subject.subjectId} className='card'>
                                <div className="row">
                                        <div className="col-2">
                                            <i className="fa fa-book fa-2x" aria-hidden="true"></i> 
                                        </div>
                                        <div className="col-9" style={{whiteSpace: 'nowrap', overflow: 'hidden', textOverflow: 'ellipsis'}} >
                                            <p style={{marginTop: '-1px', marginBottom: '-2px'}}>
                                                {subject.subjectCode}
                                            </p>
                                            <p style={{marginBottom: '-1px'}}>
                                                {subject.subjectName}
                                            </p>
                                        </div>
                                    </div>
                            </CurriculumCard>
                        ))}
                    </div>
                </div>
            </div>
        )
    }
}