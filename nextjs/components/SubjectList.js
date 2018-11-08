import React from 'react'
import 'isomorphic-fetch'
import axios from '../util/axios'
import CardSubject from '../components/CardSubject'

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
        const response = await axios.get('/subject-service/curriculums/')
        const curriculum = await response.json()
        this.setState({ curriculum: curriculum })
    }

    async getSubjectList(id) {
        let curriculumId = id.target.value
        const response = await fetch('http://localhost:80/subjectlist/curriculum/' + curriculumId)
        const subjectList = await response.json()
        this.setState({ subjectList: subjectList })
    }

    render() {

        const cardSubject = this.state.subjectList.map(subject => {
            return <CardSubject 
                    subject_id = {subject.subject_id}
                    subject_name = {subject.subject_name}
            />
        })

        return (
            <div>
                <div>
                    {this.state.curriculum.map(curriculum =>
                            <button onClick={this.getSubjectList} value={curriculum.curriculumId}>
                                {curriculum.curriculumCode}
                            </button>
                    )}
                </div>

                <div className="row">
                    {cardSubject}
                </div>
            </div>
        )
    }
}