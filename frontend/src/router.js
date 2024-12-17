
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import BookManagementBookManager from "./components/listers/BookManagementBookCards"
import BookManagementBookDetail from "./components/listers/BookManagementBookDetail"

import BookListView from "./components/BookListView"
import BookListViewDetail from "./components/BookListViewDetail"
import BookDetailsView from "./components/BookDetailsView"
import BookDetailsViewDetail from "./components/BookDetailsViewDetail"
import LoanManagementLoanManager from "./components/listers/LoanManagementLoanCards"
import LoanManagementLoanDetail from "./components/listers/LoanManagementLoanDetail"

import LoanHistoryView from "./components/LoanHistoryView"
import LoanHistoryViewDetail from "./components/LoanHistoryViewDetail"
import LoanDetailsView from "./components/LoanDetailsView"
import LoanDetailsViewDetail from "./components/LoanDetailsViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/bookManagements/books',
                name: 'BookManagementBookManager',
                component: BookManagementBookManager
            },
            {
                path: '/bookManagements/books/:id',
                name: 'BookManagementBookDetail',
                component: BookManagementBookDetail
            },

            {
                path: '/bookManagements/bookLists',
                name: 'BookListView',
                component: BookListView
            },
            {
                path: '/bookManagements/bookLists/:id',
                name: 'BookListViewDetail',
                component: BookListViewDetail
            },
            {
                path: '/bookManagements/bookDetails',
                name: 'BookDetailsView',
                component: BookDetailsView
            },
            {
                path: '/bookManagements/bookDetails/:id',
                name: 'BookDetailsViewDetail',
                component: BookDetailsViewDetail
            },
            {
                path: '/loanManagements/loans',
                name: 'LoanManagementLoanManager',
                component: LoanManagementLoanManager
            },
            {
                path: '/loanManagements/loans/:id',
                name: 'LoanManagementLoanDetail',
                component: LoanManagementLoanDetail
            },

            {
                path: '/loanManagements/loanHistories',
                name: 'LoanHistoryView',
                component: LoanHistoryView
            },
            {
                path: '/loanManagements/loanHistories/:id',
                name: 'LoanHistoryViewDetail',
                component: LoanHistoryViewDetail
            },
            {
                path: '/loanManagements/loanDetails',
                name: 'LoanDetailsView',
                component: LoanDetailsView
            },
            {
                path: '/loanManagements/loanDetails/:id',
                name: 'LoanDetailsViewDetail',
                component: LoanDetailsViewDetail
            },


    ]
})
