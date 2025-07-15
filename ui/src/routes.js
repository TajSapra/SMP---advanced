import loadable from '@loadable/component'
const HomePageComponent = loadable(() => import('./components/pages/Home.jsx'))

const routes = [
    {
        path: '/',
        component: HomePageComponent
    }
]

export default routes;