<template>

    <v-data-table
        :headers="headers"
        :items="bookList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'BookListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            bookList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/bookLists'))

            temp.data._embedded.bookLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.bookList = temp.data._embedded.bookLists;
        },
        methods: {
        }
    }
</script>

