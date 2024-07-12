<template>
  <q-page class="q-pa-lg">
    <section class="row justify-center">
      <div class="text-h3 q-my-lg">게시판</div>
    </section>
    <q-separator class="q-mb-lg"/>
    <section class="q-mx-lg column">
      <div class="q-mb-lg">
        <q-btn label="신규등록" @click="add" class="float-right" type="submit" color="secondary" />
      </div>
    </section>
    <div class="q-pa-md">
      <q-table
        title="Project Board"
        :rows="rows"
        :columns="columns"
        row-key="name"
      >
        <template #body-cell-action="props">
          <q-td align="center">
            <q-btn padding="xs sm" flat label="상세" @click="detail(props.row.name)"></q-btn>
            <q-btn padding="xs sm" flat label="수정" color="light-blue-7" @click="modify(props.row.name)"></q-btn>
            <q-btn padding="xs sm" flat label="삭제" color="orange-8" @click="deleteData(props.row.name)"></q-btn>
          </q-td>
        </template>
      </q-table>
    </div>
  </q-page>
</template>

<script>
export default {
  data () {
    return {
      rows: [
        { name: 'Ice cream sandwich', calories: 237, fat: 9.0 },
        { name: 'Eclair', calories: 262, fat: 16.0 },
        { name: 'Cupcake', calories: 305, fat: 3.7 },
        { name: 'Gingerbread', calories: 356, fat: 16.0 }
      ],
      columns: [
        { name: 'no', align: 'left', label: '#', field: 'no'},
        { name: 'projectTitle', align: 'center', label: '프로젝트명', field: 'name'},
        { name: 'strDt', align: 'center', label: '시작일자', field: 'calories'},
        { name: 'endDt', align: 'center', label: '종료일자', field: 'fat'},
        { name: 'registrant', align: 'center', label: '작성자', field: 'fat'},
        { name: 'action', align: 'center', label: '관리', field: '' }
      ]
    }
  },
  methods: {
    add() {
      console.log('신규등록 버튼 클릭');
    },
    detail(key) {
      console.log('상세 버튼 클릭', key);
    },
    modify(key) {
      console.log('수정 버튼 클릭', key);
    },
    deleteData(key) {
      console.log('삭제 버튼 클릭', key);
    }
  }
}
</script>

<style lang="scss" scoped>
</style>
