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
        let {data} = await axios.get('subject-service/curriculums')
        this.setState({ 
            curriculum: {data}.data 
        })
    }

    async getSubjectList(id) {
        let curriculumId = id.target.value
        let {data} = await axios.get('subject-service/subjectlist/curriculum/' + curriculumId)
        this.setState({ subjectList: {data}.data })
    }

    render() {

        const cardSubject = this.state.subjectList.map(subject => {
            return <CardSubject 
                    subject_id = {subject.subjectId}
                    subject_name = {subject.subjectName}
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