<template>
  <q-page class="q-pa-lg">
  <section class="row justify-center">
    <div class="text-h3 q-my-lg">게시판</div>
  </section>
  <section class="q-pa-lg" >
    <q-form
      @submit="onSubmit"
      @reset="onReset"
      class="q-gutter-md"
    >
      <q-input
        filled
        v-model="name"
        label="제목 *"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />

      <q-input
        filled
        label="내용"
        lazy-rules
      />
      <div>
        <q-btn label="Submit" type="submit" color="primary"/>
        <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
      </div>
    </q-form>
  </section>
    <q-separator class="q-mb-lg"/>
  <section class="q-mx-lg column">
    <div class="q-mb-lg ">
      <q-btn label="등록" class="float-right" type="submit" color="secondary"/>
    </div>
    <div class="row">
    <q-card class="my-card col-4">
      <q-card-section>
        <div class="text-h6">Our Changing Planet</div>
        <div class="text-subtitle2">by John Doe</div>
      </q-card-section>

      <q-separator />

      <q-card-actions vertical>
        <q-btn flat>Action 1</q-btn>
        <q-btn flat>Action 2</q-btn>
      </q-card-actions>
    </q-card>
    </div>
  </section>
  </q-page>
  <section></section>
</template>

<script setup>

</script>

<style lang="scss" scoped>

</style>
