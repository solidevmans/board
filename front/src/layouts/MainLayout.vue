<template>
  <q-layout view="lHh Lpr lFf" class="">
    <q-header elevated class="">
      <q-toolbar class="q-py-lg">
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleLeftDrawer"
        />

        <q-toolbar-title>
          게시판
        </q-toolbar-title>

        <div>Quasar v{{ $q.version }}</div>
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if-above
      bordered
    >
      <q-list>
        <q-item-label
          header
        >
          Essential Links
        </q-item-label>

        <EssentialLink
          v-for="link in linksList"
          :key="link.title"
          v-bind="link"
        />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
const linksList = [
  {
    title: 'Typography',
    caption: 'quasar.dev',
    icon: 'school',
    to: '/typography'
  },
  {
    title: 'Post',
    caption: 'quasar.dev',
    icon: 'school',
    to: '/post'
  },
]
</script>

<script setup>
import { ref } from 'vue'
import EssentialLink from 'components/EssentialLink.vue'


const leftDrawerOpen = ref(false)

function toggleLeftDrawer () {
  leftDrawerOpen.value = !leftDrawerOpen.value
}
</script>
